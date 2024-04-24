import { useState, useEffect } from "react";

const ImgRotator = ({images}:{images:string[]}) => {
  const [activeImg, setActiveImg] = useState(0);
  useEffect(() => {
    const activeImgs = document.querySelectorAll("img");
    setTimeout(() => {
      activeImgs[activeImg].classList.toggle("opacity-100");
      activeImgs[activeImg].classList.toggle("opacity-0");
      if (activeImg === images.length - 1) {
        activeImgs[0].classList.toggle("opacity-100");
        activeImgs[0].classList.toggle("opacity-0");
        setActiveImg(0);
      } else {
      activeImgs[activeImg+1].classList.toggle("opacity-100");
      activeImgs[activeImg+1].classList.toggle("opacity-0");
      setActiveImg(activeImg + 1);
      }
    }, 5000);
  }, [activeImg]);

  return (
    <>
    {images.map((image, index) => {
    if (index === 0) {
      return (
        <img
          src={image}
          key={index}
          alt={`${index}`}
          className="opactity-100 transition-opacity duration-[2000ms] ease-in-out"
        />
      );
    }
    return (
      <img key={index} src={image} alt={`${index}`} className="opacity-0 transition-opacity duration-[2000ms] ease-in-out"/>
    )
    }
    )
  }
    </>
  );
}

export default ImgRotator;