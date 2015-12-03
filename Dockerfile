FROM clojure
COPY . /app
WORKDIR /app
VOLUME /app/config
ENV RING_ENV production
CMD ["lein" "ring" "server-headless" "80"]
EXPOSE 80
