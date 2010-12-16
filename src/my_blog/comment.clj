(ns my-blog.comment
  (:use clojure.contrib.sql)
  (:require [clj-record.boot]
            [clj-record [query :as query]]
            [my-blog.config :as config])
  (:refer-clojure :exclude (find create)))

(def db (config/*MY-BLOG-DB* :development))
(clj-record.core/init-model
 (:associations (belongs-to post)))

