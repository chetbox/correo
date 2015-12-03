# Correo

A really simple web server to send emails

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

## Configuration

Copy `config.example.edn` to `config.edn` and set it up with your email server details.

## Running

To start a web server for the application, run:

    lein ring server-headless

## Sending a message

    curl -X POST -H "Content-Type: application/json" -d '{"to": ["123@abc.com"], "subject":"test", "body": "Nothing to see here."}' http://localhost:3000/send

## License

Distributed under the MIT License.
