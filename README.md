This is an exercise problem:

DataPipeline - is an abstracted representation of real world data processing pipelines. 
The pipeline takesa csv input file and processes it by its business logic. However the 
pipeline has few bugs. Design an test automation suite that tests this pipeline by generating 
input data, run the pipeline ( by invoking DataPipeline.process(input,output,delimiter) )
API and compare the actual output with expected output. The automation report should point
out which rows did not match. 

input csv format:
id(integer),text(String),timestamp(String)

output csv format:
id(integer),text(String),timestamp(String)
