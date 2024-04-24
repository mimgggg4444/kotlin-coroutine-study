import { useState } from "react";

const useDarkMode = () => {
  const [darkMode, setDarkMode] = useState(false);

  const handleChange = () => {
    document.body.classList.toggle('dark');
    setDarkMode(!darkMode);
  };

  const DarkModeToggle = () => (
    <div className={"rounded-full w-16 h-8 relative border-black border-2 flex items-center overflow-visible" + `${darkMode ? " bg-green-500":" bg-white"}`} onClick={handleChange}>
      <div className={'rounded-full w-10 h-10 relative bg-gray-500 grid place-items-center border-2 border-black'+ `${darkMode ? " left-[calc(100%-40px)]":" -left-2"}`}>
        {darkMode ? <span className="material-symbols-outlined">
dark_mode
</span>:<span className="material-symbols-outlined">
light_mode
</span>}
      </div>
    </div>
  )

  return { DarkModeToggle };
};

export default useDarkMode;