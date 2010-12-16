(ns my-blog.post
  (:use clojure.contrib.sql)
  (:require [clj-record.boot]
            [clj-record [query :as query]]
            [my-blog.config :as config])
  (:refer-clojure :exclude (find create)))

(def db (config/*MY-BLOG-DB* :development))
(clj-record.core/init-model
 (:associations (has-many comments)))

(defn find-all-posts []
  (find-records {:id (query/greater-than 0)}))


(defn create-post [attributes]
  (create attributes))

(defn update-post [attributes]
  (update attributes))

(defn find-post [id]
  (find-record {:id id}))
