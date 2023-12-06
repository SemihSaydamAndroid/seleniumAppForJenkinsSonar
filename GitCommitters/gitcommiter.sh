#!/bin/bash

# GitHub'dan erişim anahtarını almak için: GitHub -> Profil -> Ayarlar -> Geliştirici Ayarları -> Kişisel Erişim Anahtarı

read -p "Commit mesajını giriniz: " commit_message
read -p "Hangi hesabınıza commit yapmak istiyorsunuz? Eğer iş hesabınızdaysa 'work' yazabilirsiniz: " account_type
read -p "Repository adını giriniz [varsayılan: my-repo]: " repo_name

repo_name="${repo_name:-seleniumAppForJenkinsSonar}"
echo "repo_name = $repo_name"

read -p "Proje yolunu giriniz [varsayılan: /Users/kullanici/proje]: " project_path
project_path="${project_path:-/Users/asaf/Desktop/Discipline/projects/DDevOps/seleniumAppForJenkinsSonar}"
echo "project_path = $project_path"

personal_access_token="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"
work_access_token="<work_access_token>"

if [ "$account_type" == "work" ]; then
    git config --global user.name "----"
    git config --global user.email "----@garantibbva.com.tr"
    username="---"
    access_token="$work_access_token"
else
    git config --global user.name "SemihSaydamAndroid"
    git config --global user.email "semihsaydamz@gmail.com"
    username="SemihSaydamAndroid"
    access_token="$personal_access_token"
fi

git_url="https://$username:$access_token@github.com/$username/$repo_name.git"
echo "git_url = $git_url"

cd "$project_path" || exit

if git status | grep -q "nothing to commit"; then
    echo "Commit edilecek bir şey yok. Çıkılıyor..."
    exit 1
fi

git add .

git commit -m "$commit_message"

git push "$git_url"
