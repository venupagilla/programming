import kagglehub

# Download latest version
path = kagglehub.dataset_download("gmudit/employer-data")

print("Path to dataset files:", path)