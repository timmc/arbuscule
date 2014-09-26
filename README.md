# org.timmc/arbuscule

A Leiningen plugin to descend into the full dependency tree of a project.

## Usage

Put `[arbuscule "0.1.0"]` into the `:plugins` vector of your
`:user` profile.

And then run this in a project:

    $ lein arbuscule :dump target/dependency-tree.clj

## License

Copyright © 2014 Tim McCormack

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
