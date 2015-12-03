FROM clojure

# Install
COPY . /app
WORKDIR /app
VOLUME /app/config
RUN lein deps

# Test
RUN lein test

# Run
ENV RING_ENV production
CMD lein ring server-headless 80
EXPOSE 80

