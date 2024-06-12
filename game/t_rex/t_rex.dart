import 'dart:ui';

import 'package:flame/components.dart';
import 'package:flame/sprite.dart';
import 'package:trex/game/game.dart';
import 'package:trex/game/t_rex/config.dart';

enum TRexStatus { crashed, ducking, jumping, running, waiting, intro }

class InvincibleTRex extends TRexStateStillComponent {
  InvincibleTRex(Image spriteImage, TRexConfig config)
      : super(
    showFor: [TRexStatus.running, TRexStatus.jumping],
    config: config,
    spriteImage: spriteImage,
    srcPosition: Vector2(1782.0, 6.0), // 무적 상태일 때의 스프라이트 위치
    showWhenInvincible: true, // 무적 상태일 때만 보여줌
  );
}

class TRex extends PositionComponent with HasGameRef<TRexGame> {
  final config = TRexConfig();


  // 아이템 관련 변수 추가
  bool hasItem = false;
  bool isInvincible = false;
  double itemTimer = 0;
  double invincibleTimer = 0;


  // state
  TRexStatus status = TRexStatus.waiting;
  bool isIdle = true;

  double jumpVelocity = 0.0;
  bool reachedMinHeight = false;
  int jumpCount = 0;
  bool hasPlayedIntro = false;

  // ref to children
  late final WaitingTRex idleDino = WaitingTRex(gameRef.spriteImage, config);
  late final RunningTRex runningDino =
      RunningTRex(gameRef.spriteImage, config);
  late final JumpingTRex jumpingTRex =
      JumpingTRex(gameRef.spriteImage, config);
  late final SurprisedTRex surprisedTRex = SurprisedTRex(
    gameRef.spriteImage,
    config,
  );

  bool get playingIntro => status == TRexStatus.intro;

  bool get ducking => status == TRexStatus.ducking;

  double get groundYPos {
    return (gameRef.size.y / 2) - config.height / 2;
  }

  @override
  Future? onLoad() {
    add(idleDino);
    add(runningDino);
    add(jumpingTRex);
    add(surprisedTRex);
    add(InvincibleTRex(gameRef.spriteImage, config)); // 무적 상태 스프라이트 추가

  }

  void startJump(double speed) {
    if (status == TRexStatus.jumping || status == TRexStatus.ducking) {
      return;
    }

    status = TRexStatus.jumping;
    jumpVelocity = config.initialJumpVelocity - (speed / 10);

    reachedMinHeight = false;
  }

  void reset() {
    y = groundYPos;
    jumpVelocity = 0.0;
    jumpCount = 0;
    status = TRexStatus.running;
  }


  void getItem() {
    hasItem = true;
  }

  // 무적 상태 함수 추가
  void activateInvincibility() {
    if (hasItem) {
      isInvincible = true;
      invincibleTimer = 5; // 5초간 무적
      hasItem = false;
    }
  }


  @override
  void update(double dt) {
    if (status == TRexStatus.jumping) {
      y += jumpVelocity;
      jumpVelocity += config.gravity;
      if (y > groundYPos) {
        reset();
        jumpCount++;
      }
    } else {
      y = groundYPos;
    }

    // intro related
    if (jumpCount == 1 && !playingIntro && !hasPlayedIntro) {
      status = TRexStatus.intro;
    }
    if (playingIntro && x < config.startXPos) {
      x += (config.startXPos / config.introDuration) * dt * 5000;
    }

    // 아이템 및 무적 타이머 업데이트
    if (hasItem) {
      itemTimer += dt;
      if (itemTimer >= 10) { // 10초 후에 아이템 사라짐
        hasItem = false;
        itemTimer = 0;
      }
    }

    if (isInvincible) {
      invincibleTimer -= dt;
      if (invincibleTimer <= 0) {
        isInvincible = false;
      }
    }

    super.update(dt);
  }

  @override
  void onGameResize(Vector2 gameSize) {
    y = groundYPos;
    super.onGameResize(gameSize);
  }
}

mixin TRexStateVisibility on Component {
  late final List<TRexStatus> showFor;
  late final bool showWhenInvincible; // 무적 상태일 때 보여줄지 여부를 나타내는 프로퍼티 추가


  @override
  TRex get parent => super.parent as TRex;

  @override
  void render(Canvas canvas) {
    super.render(canvas);


    final show = showFor.any((element) => element == parent.status);
    if (!show && !(showWhenInvincible && parent.isInvincible)) { // 무적 상태일 때는 showWhenInvincible 값에 따라 렌더링 여부 결정
      return;
    }

    super.render(canvas);
  }
}

/// A component superclass for TRex states with still sprites
class TRexStateStillComponent extends SpriteComponent with TRexStateVisibility {
  TRexStateStillComponent({
    required List<TRexStatus> showFor,
    required Image spriteImage,
    required TRexConfig config,
    required Vector2 srcPosition,
    bool showWhenInvincible = false, // 기본값은 false

  }) : super(
          size: Vector2(config.width, config.height),
          sprite: Sprite(
            spriteImage,
            srcPosition: srcPosition,
            srcSize: Vector2(config.width, config.height),
          ),
        ) {
    this.showFor = showFor;
  }
}

class TRexStateAnimatedComponent extends SpriteAnimationComponent
    with TRexStateVisibility {
  TRexStateAnimatedComponent({
    required List<TRexStatus> showFor,
    required Image spriteImage,
    required TRexConfig config,
    required Vector2 size,
    required List<Vector2> frames,
    bool showWhenInvincible = false, // 기본값은 false

  }) : super(
          size: size, //,
          animation: SpriteAnimation.spriteList(
            frames
                .map((vector) => Sprite(
                      spriteImage,
                      srcSize: Vector2(config.width, config.height),
                      srcPosition: vector,
                    ))
                .toList(),
            stepTime: 0.2,
            loop: true,
          ),
        ) {
    this.showFor = showFor;
  }
}

class RunningTRex extends TRexStateAnimatedComponent {
  RunningTRex(
    Image spriteImage,
    TRexConfig config,
  ) : super(
          showFor: [TRexStatus.running, TRexStatus.intro],
          spriteImage: spriteImage,
          size: Vector2(88.0, 90.0),
          config: config,
          frames: [Vector2(1514.0, 4.0), Vector2(1602.0, 4.0)],
        );
}

class WaitingTRex extends TRexStateStillComponent {
  WaitingTRex(Image spriteImage, TRexConfig config)
      : super(
          showFor: [TRexStatus.waiting],
          config: config,
          spriteImage: spriteImage,
          srcPosition: Vector2(76.0, 6.0),
        );
}

class JumpingTRex extends TRexStateStillComponent {
  JumpingTRex(Image spriteImage, TRexConfig config)
      : super(
          showFor: [TRexStatus.jumping],
          config: config,
          spriteImage: spriteImage,
          srcPosition: Vector2(1339.0, 6.0),
        );
}

class SurprisedTRex extends TRexStateStillComponent {
  SurprisedTRex(Image spriteImage, TRexConfig config)
      : super(
          showFor: [TRexStatus.crashed],
          config: config,
          spriteImage: spriteImage,
          srcPosition: Vector2(1782.0, 6.0),
        );
}
