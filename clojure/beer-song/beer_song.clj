(ns beer-song
  (:require [clojure.string :as s]))

(defn- bottles-of-beer
  [idx]
  (case idx
    -1 "99 bottles"
    0 "no more bottles"
    1 "1 bottle"
    (str idx " bottles")))

(defn- take-one-down
  [idx]
  (case idx
    0 "Go to the store and buy some more"
    1 "Take it down and pass it around"
    "Take one down and pass it around"))

(defn verse
  [idx]
  (let [current (bottles-of-beer idx)
        action (take-one-down idx)
        remaining (bottles-of-beer (dec idx))]
    (format "%s of beer on the wall, %s of beer.\n%s, %s of beer on the wall.\n"
            (s/capitalize current)
            current
            action
            remaining)))
(defn sing
  ([from]
   (sing from 0))
  ([from to]
   (->>
     (range from (dec to) -1)
     (map verse)
     (s/join "\n"))))
