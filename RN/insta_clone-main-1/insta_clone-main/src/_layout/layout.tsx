import { PropsWithChildren } from "react";
import useDarkMode  from "../_hooks/useDarkMode";

const Layout = ({children}: PropsWithChildren) => {
  const { DarkModeToggle } = useDarkMode();
  return (
  <>
  <nav className="flex justify-end pt-8 px-8"> <DarkModeToggle/> </nav>
  <main>{children}</main>
  <footer className=" text-xs text-center mx-auto flex gap-4 justify-center">
    <div>Meta</div>
    <div>About</div>
    <div>Blog</div>
    <div>Jobs</div>
    <div>Help</div>
    <div>API</div>
    <div>Privacy</div>
    <div>Terms</div>
    <div>Location</div>
    <div>Instagram Lite</div>
    <div>Threads</div>
    <div>Contact Uploading & Non-Users</div>
    <div>Meta Verified"</div>
    </footer>
  </>
  )
};

export default Layout;