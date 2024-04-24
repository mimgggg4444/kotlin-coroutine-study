import { defineConfig } from 'vite'
import { resolve } from 'path'
import react from '@vitejs/plugin-react-swc'
import  svgr  from '@svgr/rollup'

const root =  resolve(__dirname, 'src')
const outDir = resolve(__dirname, 'dist')
const publicDir = resolve(__dirname, 'public')
const main = resolve(__dirname, root, "index.html")

// https://vitejs.dev/config/
export default defineConfig({
  root,
  publicDir,
  plugins: [react(), svgr()],
  build: {
    outDir,
    emptyOutDir: true,
    rollupOptions: {
      input: {
        main,
      }
    },
  },
})
