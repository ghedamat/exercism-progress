(ns anagram
  (:require [clojure.string :as s]))

(defn- is-anagram?
  [word anagram]
  (let [w (s/lower-case word)
        a (s/lower-case anagram)]
    (and
      (not= w a)
      (= (frequencies w) (frequencies a)))))

(defn anagrams-for
  [word words]
  (filter (partial is-anagram? word) words))
