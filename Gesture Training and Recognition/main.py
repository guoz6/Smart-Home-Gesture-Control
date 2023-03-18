import cv2
#import numpy as np
import os
import pandas as pd
from sklearn.metrics.pairwise import cosine_similarity as cos_sim
from frameextractor import frameExtractor
from handshape_feature_extractor import HandShapeFeatureExtractor

# Load the pre-trained CNN model using the HandShapeFeatureExtractor class
model = HandShapeFeatureExtractor.get_instance()

# Get the penultimate layer for training data
ta_path = "traindata/"
feature_vector_list = []
count = 0
for file in os.listdir(ta_path):
    if not file.startswith('frames') and "Store" not in file:
        try:
            output_label = int(file.split('_')[0])
        except ValueError:
            continue # Skip files that don't start with a valid integer
        
        unique_id = file.split('_')
        gesture_name = file.split('_')[1]
        gesture_details = (unique_id, gesture_name, output_label)
        
        # extract features from the middle frame of the video
        ##middle_image = cv2.imread(frameExtractor(ta_path + file, ta_path + "frames/", count), cv2.IMREAD_COLOR)
        frameExtractor(ta_path + file, ta_path + "frames", count)
        middle_image = cv2.imread( ta_path + "frames/" +"%05d.png" % (count+1), cv2.IMREAD_GRAYSCALE)
        extracted_feature = model.extract_feature(middle_image)
        
        feature_vector_list.append((extracted_feature, gesture_details))
        count = count + 1

# Recognize the gesture (use cosine similarity for comparing the vectors)
count = 0
te_path = "test/"
recognized_gesture_list = []
for test_file in os.listdir(te_path):
    if not test_file.startswith('frames') and "Store" not in test_file:
        # extract features from the middle frame of the video
        ##middle_image = cv2.imread(frameExtractor(te_path + test_file, te_path + "frames/", count), cv2.IMREAD_COLOR)
        frameExtractor(te_path + test_file, te_path + "frames", count)
        middle_image = cv2.imread( te_path + "frames/" +"%05d.png" % (count+1), cv2.IMREAD_GRAYSCALE)
        video_feature = model.extract_feature(middle_image)
        
        # compare the video feature with all the training data features using cosine similarity
        similarity_list = []
        for extracted_feature, gesture_details in feature_vector_list:
            cosine_similarity = cos_sim(extracted_feature.reshape(1, -1), video_feature.reshape(1, -1))[0][0]
            similarity_list.append((cosine_similarity, gesture_details))
        
        # choose the gesture with the lowest cosine similarity as the recognized gesture
        recognized_gesture = min(similarity_list, key=lambda x: x[0])[1]
        recognized_gesture_list.append((recognized_gesture[2]))
        count = count + 1

# Output the results to a CSV file
df = pd.DataFrame(recognized_gesture_list)
##df.to_csv('results.csv', index=False, header = None)
df.to_csv('Results.csv', index=False, header = None)