cmake_minimum_required(VERSION 3.4.1)

add_library(com_jayplabs_fibonaccinative_FibLib SHARED
            com_jayplabs_fibonaccinative_FibLib.c)

# Include libraries needed for hello-jni lib
target_link_libraries(com_jayplabs_fibonaccinative_FibLib log android)
