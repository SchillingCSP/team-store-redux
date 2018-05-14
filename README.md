# team-store-redux

# Adding React Native
## Install React Native
https://facebook.github.io/react-native/
https://facebook.github.io/react-native/docs/getting-started.html
### install nvm
http://dev.topheman.com/install-nvm-with-homebrew-to-use-multiple-versions-of-node-and-iojs-easily/

brew update
brew install nvm
mkdir ~/.nvm
nano ~/.bash_profile

add to the bash_profile
export NVM_DIR=~/.nvm
source $(brew --prefix nvm)/nvm.sh

back in terminal
source ~/.bash_profile
echo $NVM_DIR

### install node
revert npm to version 4
nvm install 7.10.1

### use node
npm install -g create-react-native-app
create-react-native-app AwesomeProject

## Install Expo on your device

## Scan the code on your device

## Install the Create a Project with React Native
nvm install -g create-react-native-app
from the working directory
create-react-native-app schilling-store-rn-yourname
cd schilling-store-rn-yourname
npm start

if you get errors, the you can probably run these commands to fix it:

  sudo sysctl -w kern.maxfiles=5242880
  sudo sysctl -w kern.maxfilesperproc=524288
  
Add this to the dependencies in package.json

npm install --save react-navigation
    "react-navigation": "^1.5.7"  
