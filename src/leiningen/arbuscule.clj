(ns leiningen.arbuscule
  (:require [leiningen.core.main :refer [debug info warn abort]]
            [cemerick.pomegranate.aether :as aether]
            [clojure.pprint :refer [pprint]]))

(defn resolve-deps
  [project]
  (aether/resolve-dependencies :coordinates
                               (:dependencies project)))

(defn dump-deps
  [project path]
  (spit path (pr-str (resolve-deps project))))

(defn print-deps
  [project]
  (info (with-out-str (pprint (resolve-deps project)))))

(defn arbuscule
  "Analyze the full dependency tree of a leiningen project.

Usage:

- `:dump <path>` will dump the dependency tree to the specific path as
  a Cloure data structure.
- `:print` will instead pretty-print it to stdout"
  [project & args]
  (cond (and (= (count args) 2)
             (= (first args) ":dump"))
        (dump-deps project (second args))

        (and (= (count args) 1)
             (= (first args) ":print"))
        (print-deps project)

        :else (abort "Unknown task for arbuscule")))
