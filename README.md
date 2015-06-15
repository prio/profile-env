# profile-env

A Leiningen plugin that outputs profile information so it can be used by bash or docker. Designed to be used with [environ](https://github.com/weavejester/environ).

## Install

Add to your ~/.lein/profiles.clj or include it in your project plugins.

    [org.jonharrington/profile-env "0.1.0"]
    

## Usage

To output dev/testing profile

    $ lein profile-env
    AWS_ACCESS_KEY=
    AWS_ACCESS_KEY_ID=
    AWS_REGION=http://localhost:8000
    DB_URL=postgres://localhost

To source into bash

    $ lein profile-env > local.env
    $ set -a
    $ . local.env
    $ echo $DB_URL
    postgres://localhost

To use with docker

    $ lein profile-env > local.env
    $ docker run --env-file local.env ...

To get info from another profile, just use with-profile as normal
    
    $ lein with-profile staging profile-env
    AWS_ACCESS_KEY=SECRET
    AWS_ACCESS_KEY_ID=SECRET
    AWS_REGION=http://eu-east1....
    DB_URL=postgres://....    
    

## License

Copyright © 2015 Jonathan Harrington

Distributed under the BSD-2 license.
