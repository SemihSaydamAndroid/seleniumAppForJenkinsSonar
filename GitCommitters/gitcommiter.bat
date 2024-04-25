@echo off
color 0f
REM access token almak için github --> Profile --> Settings --> Developer Settings --> Personal Access Token

set /p commit_message="Commit mesajini girer misin: "
set /p account_type="Is hesabina mi commit atmak istiyorsun? Eger ogleyse work yazabilirsin (work): "
set /p repo_name="Repository ismini girer misin [default: my-repo]: " 
if "%repo_name%"=="" set "repo_name=seleniumAppForJenkinsSonar"

set /p project_path="Proje yolunu girer misin [default: C:\Projects..\my-app]: "   
if "%project_path%"=="" set "project_path=C:\Users\Semih\Desktop\Discipline\Projects\DevOps\Docker\sonarPlugin\my-app"

set personal_access_token=<personal_access_token>
set work_access_token=<work_access_token>

if "%account_type%"=="work" (
    git config --global user.name ----
    git config --global user.email ----@.com.tr
    set username=---
    set access_token=%work_access_token% 
) else (
    git config --global user.name SemihSaydamAndroid
    git config --global user.email ---@gmail.com
    set username=SemihSaydamAndroid
    set access_token=%personal_access_token%
)

set git_url=https://%username%:%access_token%@github.com/%username%/%repo_name%.git 

cd %project_path%

git status | findstr /C:"nothing to commit" >nul && (
    echo There is nothing to commit. Exiting...   
    exit /b 1   
)

git add .

git commit -m "%commit_message%"   

git push %git_url%
