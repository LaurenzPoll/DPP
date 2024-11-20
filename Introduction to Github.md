# English version (Chinese is below, translated by ChatGPT to make your reading easier)

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

---

---

---

# GitHub简介以及如何使用

GitHub是一个与他人协作开发代码项目的工具。它可以帮助我们跟踪更改、共享工作并整合每个人的贡献。以下是我们在GitHub上协作的分步指南。

---

## GitHub的用途是什么？
GitHub可以帮助我们：
1. **跟踪更改**（记录谁在什么时候做了什么）。
2. **协作工作**而不会覆盖彼此的工作。
3. **使用任务板**来组织任务（类似于待办事项列表）。
4. **在将工作合并到主项目之前进行审查**。

---

## 使用GitHub的关键步骤

### 1. 始终从`main`分支开始
`main`分支是项目的主要版本。当你开始一个任务时，务必要：
1. **从`main`的最新版本开始**。
2. **为你的任务创建一个新分支**。

命令：
- 切换到`main`分支：`git checkout main`
- 获取最新更新：`git fetch origin` 然后 `git pull origin main`

示例：
可以将`main`分支想象成一本共享的笔记本。在开始写作之前，请确保你拥有最新版本的笔记本。

---

### 2. 为任务创建一个分支
**分支**就像是项目的一个独立版本，你可以在其中安全地进行更改，而不会影响主分支。

命令：
- 创建一个新分支：`git branch my-new-branch`
- 切换到新分支：`git checkout my-new-branch`

示例：
将分支看作你的私人工作空间。在这里，你可以自由试验和更改，而不会干扰团队的其他成员。

---

### 3. 添加并提交你的更改
当你进行更改时，GitHub不会自动保存它们。你需要：
1. **将更改添加**到“暂存区”，使用`git add`。
2. **保存更改**（提交），使用`git commit`。

命令：
- 添加更改：`git add file-name`（或`git add .`添加所有更改）
- 提交更改：`git commit -m "你的提交信息"`

示例：
添加更改就像将物品放入篮子中。提交就像封好篮子并附上一张关于内容的便条。

---

### 4. 将你的分支推送到GitHub
一旦你的工作准备好了，将你的分支上传（推送）到GitHub，以便其他人可以查看。

命令：
- 推送分支：`git push origin my-new-branch`

示例：
推送就像将你的私人工作空间分享给团队，让他们可以审查你的工作。

---

### 5. 获取并拉取更新保持最新
其他团队成员也在进行项目工作，所以`main`分支可能会有变化。为了避免冲突：
1. **获取**更改以查看最新内容：`git fetch origin`
2. **拉取**更改以更新你的分支：`git pull origin main`

示例：
获取就像检查有没有新邮件，拉取就像实际阅读邮件。

---

### 6. 将你的工作合并到`main`中
一旦你的分支准备好并通过审核：
1. 切换到`main`分支：`git checkout main`
2. 更新`main`：`git pull origin main`
3. 合并你的分支：`git merge my-new-branch`

示例：
合并就像将你的工作与团队的笔记本结合在一起。

---

### 7. 将更新后的`main`推送到GitHub
合并分支后，你需要将更新后的`main`分支推送到GitHub。

命令：
- 推送`main`：`git push origin main`

---

## 关键命令总结
1. 切换到`main`并更新：
   - `git checkout main`
   - `git fetch origin`
   - `git pull origin main`

2. 创建一个分支：
   - `git branch my-new-branch`
   - `git checkout my-new-branch`

3. 添加并提交更改：
   - `git add .`
   - `git commit -m "更改的描述"`

4. 推送你的分支：
   - `git push origin my-new-branch`

5. 将你的分支合并到`main`：
   - `git checkout main`
   - `git pull origin main`
   - `git merge my-new-branch`
   - `git push origin main`
