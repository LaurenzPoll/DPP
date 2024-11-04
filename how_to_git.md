# How to work with git in the terminal

## Creating a clone, a branch and merging

**Make sure your terminal is open in the folder where you want to clone the repository.**

1. Clone the repository  
   `git clone <repository_url>`


2. Change directory to the repository  
   `cd <repository_name>`


3. Check the status of the repository  
   `git status`


4. Pull the latest changes from the main branch  
   `git pull origin main`


5. Create and switch to a new branch  
   `git checkout -b <new_branch_name>`


6. Stage all changes or a specific file  
   `git add .` or `git add file.txt`


7. Commit the changes with a message  
   `git commit -m "Your commit message"`


8. Push the new branch to the remote repository  
   `git push origin <new_branch_name>`


9. Switch back to the main branch  
    `git switch main`


10. Pull the latest changes from the main branch to ensure it's up to date  
    `git pull origin main`


11. Merge your branch into main (remember that there can be merge conflicts happening here, these need to be resolved)  
    `git merge <new_branch_name>`


12. Push the updated main branch to the remote repository  
    `git push origin main`