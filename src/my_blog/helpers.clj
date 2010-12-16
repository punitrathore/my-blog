(ns my-blog.helpers
  (:use (hiccup [core :only [html escape-html]]
                [page-helpers :only [link-to]]
                [form-helpers :only [submit-button label form-to text-field text-area hidden-field]])))

(defn form-row [field_label_name name element_name element_class]
  [:div
   (label name (str field_label_name ":"))
   [:div {:class element_class} (element_name name)]])

(defn submit-row [submit_label]
  [:div.submit
   (submit-button submit_label )])
