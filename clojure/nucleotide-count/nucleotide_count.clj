(ns nucleotide-count
  (:require [clojure.string :as s]))

(defn count
  [nucleotide dna]
  (if (some #(= nucleotide %) [\A \T \C \G])
    (get (frequencies dna) nucleotide 0)
    (throw (Exception. "invalid nucleotide"))))

(defn nucleotide-counts
  [dna]
  (merge {\A 0 \T 0 \C 0 \G 0}
         (frequencies dna)))
