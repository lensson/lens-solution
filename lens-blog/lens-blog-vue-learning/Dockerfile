FROM node:latest as build-stage
WORKDIR /app
COPY package*.json ./
RUN yarn config set registry http://artifactory-espoo-fnms.int.net.nokia.com:8081/artifactory/api/npm/npm-virtual/
RUN yarn install
COPY ./ .
RUN yarn build

FROM nginx as production-stage
RUN mkdir /app
COPY --from=build-stage /app/dist /app
COPY nginx.conf /etc/nginx/nginx.conf