(ns rna-transcription)

(defn- rna-complement
  [e]
  (let [rna {\G \C \C \G \T \A \A \U}]
    (assert (rna e))
    (rna e)))

(defn to-rna
  [dna]
  (->> dna (map rna-complement) (apply str)))

