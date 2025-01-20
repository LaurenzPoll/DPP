# Frontend (Vue) Documentation

This directory contains the frontend of the application, built with Vue 3. Below is an overview of the important files and how they work together. The goal of this document is to explain only the parts that are not standard Vue functionality.

## Table of Contents
1. [Project Structure](#project-structure)
2. [Key Files and Directories](#key-files-and-directories)
    - [Base CSS](#base-css)
    - [API Calls](#api-calls-analyzecompliancejs)
    - [Vue Router](#vue-router-routerindexjs)
    - [App Entry Point](#app-entry-point-appvue-and-mainjs)
    - [Dockerfile](#dockerfile)
3. [Development Setup](#development-setup)
4. [Running the Frontend in Docker](#running-with-docker)
5. [Compile and Minify for Production](#compile-and-minify-for-production)

---

## Project Structure

```
vue_front-end/
├─ public/
│  ├─ favicon.ico
├─ src/
│  ├─ assets/
│  │  └─ base.css
│  ├─ components/
│  │  ├─ Sidebar.vue
│  │  ├─ HomePage.vue
│  │  ├─ QuickScanResults.vue
│  │  ├─ inputForm.vue
│  │  └─ api/
│  │     └─ analyzeCompliance.js
│  ├─ router/
│  │  └─ index.js
│  ├─ App.vue
│  └─ main.js
├─ index.html
└─ Dockerfile
└─ vite.config.js
```

## Key Files and Directories

### Base CSS
**Location**: `src/assets/base.css`

This file contains general (global) styling for the entire application. If you need to define any default or global CSS rules (e.g., body styling, typography, etc.), place them here.

### API Calls (`analyzeCompliance.js`)
**Location**: `src/components/api/analyzeCompliance.js`

What it does:
  - Creates an Axios instance with baseURL pointing to the backend (http://localhost:8090 by default).
  - Defines and exports the analyzeCompliance function that sends a POST request to the /list endpoint.
**Important:** If your backend runs on a different port or URL, update baseURL accordingly.

### Vue Router (`router/index.js`)
**Location**: `src/router/index.js`

- **Routes**:
    - `/` -> `HomePage.vue`
    - `/quickscan-results` -> `QuickScanResults.vue`
    - `/inputForm` -> `inputForm.vue`
    - `/information` -> `information.vue`

- **Usage**:
    - The router allows navigation between these pages.
    - The `<router-view>` in `App.vue` displays the component corresponding to the current route.

### App Entry Point (`App.vue` and `main.js`)

- **`App.vue` Purpose**:
    - `App.vue` is the root component of the Vue application.
    - Renders the `Sidebar` on the left, and the main content to the right.
    - `<router-view>` is where different pages (routes) are injected.

- **`main.js` Purpose**:
    - Bootstraps the Vue application.
    - Registers the router.
    - Mounts the root `App` component to the HTML element with the `id="app"` (see `index.html`).

### Dockerfile
**Location**: `vue_front_end/Dockerfile`

- **Build stage**: Uses `node:18` to install dependencies and build the Vue application, producing the compiled output in `dist/`.
- **Production stage**: Uses `nginx:alpine` to serve the `dist/` folder (the built frontend) on port `80`.

---

## Development Setup

1. **Install Node.js (if not already)**
    - Recommended version is Node 18 or above.

2. **Install Dependencies**
   ```bash
   cd vue_front-end
   npm install
   ```
3. Run the Development Server
   ```bash
   npm run dev
   ``` 
4. Connect to the backend
   Ensure the backend is running on port `8090`

## Running with Docker
```bash
cd vue_front_end
docker build -t frontend .
docker run -d -p 8080:80 frontend
```

### Compile and Minify for Production

```sh
npm run build
```

---
That’s it! You now have all the necessary information to understand and run the Vue frontend. For more on Vue, refer to Vue 3 documentation.