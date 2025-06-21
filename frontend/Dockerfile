#Stage - I
FROM node:18 AS build

#Add a working directory.
WORKDIR /app

#Copy package.json to get the dependencies to install 
#Copy the package-lock.json to resolve versions conflicts issue.
COPY package.json package-lock.json ./

#install dependencies which mentioned in package.json
RUN npm install

#copy the source code 
COPY . .

#build the frontend application
RUN npm run build

#Stage - II 
FROM nginx:alpine

#add this to resolve the paths navigating issue.
COPY nginx.conf /etc/nginx/nginx.conf

#copy the dist to the nginx 
COPY --from=build /app/dist /usr/share/nginx/html

#expose port
EXPOSE 80

#Run the app.
ENTRYPOINT [ "nginx","-g","daemon off;" ]