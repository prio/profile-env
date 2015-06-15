(ns leiningen.profile-env
    (require [clojure.string :as cstr]))

(use 'clojure.pprint)

(defn fmt-var [key]
      (-> (name key)
          .toUpperCase
          (cstr/replace #"-" "_")))


(defn profile-env
      "Convert the variables in 'env' into something that can be imported into bash or used by docker"
      [project & args]
      (doseq [[key value] (:env project)]
             (println (str (fmt-var key) "=" value))))
