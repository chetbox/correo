# Correo

A really simple web server to send emails

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

## Configuration

Copy `email.example.edn` to `email.edn` and set it up with your email server details.

## Running

To start a web server for the application, run:

    lein run config/email.edn 3000

## Sending a message

    curl -X POST -H "Content-Type: application/json" -d '{"to": ["123@abc.com"], "subject":"test", "body": "Nothing to see here."}' http://localhost:3000/send

## License

Distributed under the MIT License.
