# Introduction to GitHub and How to Work With It

GitHub is a tool for working on code projects with other people. It helps us track changes, share our work, and combine everyone's contributions. Here's a step-by-step guide to how we work together in GitHub.

---

## What is GitHub For?
GitHub helps us:
1. **Track changes** in our project (who did what and when).
2. **Work together** without overwriting each other's work.
3. **Organize tasks** using boards (like a to-do list).
4. **Review work** before it’s added to the main project.

---

## Key Steps for Working With GitHub

### 1. Always Start With the `main` Branch
The `main` branch is the primary version of the project. When you begin working on a task, you always:
1. **Start from the latest version of `main`**.
2. **Create a new branch** for your task.

Commands:
- To switch to the `main` branch: `git checkout main`
- To get the latest updates: `git fetch origin` followed by `git pull origin main`

Example:
Imagine the main branch is like a shared notebook. Before you start writing, make sure you have the latest version of the notebook.

---

### 2. Create a Branch for Your Task
A **branch** is like a separate version of the project where you can safely make changes without affecting the main branch.

Commands:
- To create a new branch: `git branch my-new-branch`
- To switch to the new branch: `git checkout my-new-branch`

Example:
Think of a branch as your own private workspace. You can experiment and make changes here without disturbing the rest of the team.

---

### 3. Add and Commit Your Changes
When you make changes, GitHub doesn’t save them automatically. You need to:
1. **Add your changes** to a "staging area" with `git add`.
2. **Save your changes** (commit them) with `git commit`.

Commands:
- To add changes: `git add file-name` (or `git add .` to add all changes)
- To commit changes: `git commit -m "Your message here"`

Example:
Adding changes is like putting items into a basket. Committing is like sealing the basket with a note about what’s inside.

---

### 4. Push Your Branch to GitHub
Once your work is ready, you upload (push) your branch to GitHub so others can see it.

Command:
- To push your branch: `git push origin my-new-branch`

Example:
Pushing is like sharing your private workspace with the team, so they can review your work.

---

### 5. Fetch and Pull to Keep Up-To-Date
Other team members are also working on the project, so the `main` branch might change. To avoid conflicts:
1. **Fetch** changes to see what’s new: `git fetch origin`
2. **Pull** changes to update your branch: `git pull origin main`

Example:
Fetching is like checking for new mail, and pulling is like actually reading it.

---

### 6. Merge Your Work Into `main`
Once your branch is ready and approved:
1. Switch to `main`: `git checkout main`
2. Update it: `git pull origin main`
3. Merge your branch: `git merge my-new-branch`

Example:
Merging is like combining your work with the team's notebook.

---

### 7. Push the Updated `main` to GitHub
After merging your branch, you need to push the updated `main` branch to GitHub.

Command:
- To push `main`: `git push origin main`

---

## Summary of Key Commands
1. Switch to `main` and update:
   - `git checkout main`
   - `git fetch origin`
   - `git pull origin main`

2. Create a branch:
   - `git branch my-new-branch`
   - `git checkout my-new-branch`

3. Add and commit changes:
   - `git add .`
   - `git commit -m "Description of changes"`

4. Push your branch:
   - `git push origin my-new-branch`

5. Merge your branch into `main`:
   - `git checkout main`
   - `git pull origin main`
   - `git merge my-new-branch`
   - `git push origin main`
