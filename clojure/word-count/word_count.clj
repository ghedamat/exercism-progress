(ns word-count
  (:require [clojure.string :as s]))

(defn word-count
  [msg]
  (->
    msg
    s/lower-case
    (s/split #"\W+")
    frequencies))
