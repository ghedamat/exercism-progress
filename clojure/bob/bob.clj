(ns bob
  (:require [clojure.string :as s]))

(defn- is-yielling?
  [phrase]
  (and (= phrase (s/upper-case phrase))
       (some #(Character/isUpperCase %) phrase)))

(defn- is-nothing?
  [phrase]
  (s/blank? phrase))

(defn- is-question?
  [phrase]
  (.endsWith phrase "?"))

(defn response-for
  [phrase]
  (cond
    (is-nothing? phrase) "Fine. Be that way!"
    (is-yielling? phrase) "Whoa, chill out!"
    (is-question? phrase) "Sure."
    :else "Whatever."))
