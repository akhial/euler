cmake_minimum_required(VERSION 3.25.2)

project(euler)

enable_testing()

add_library(utils lib/utils.c)
target_link_libraries(utils PUBLIC ssl crypto)

add_library(001 src/001.c)
add_executable(001_test test/001_test.c)
target_link_libraries(001_test PRIVATE 001)
target_link_libraries(001_test PRIVATE utils)
add_test(
    NAME 001
    COMMAND $<TARGET_FILE:001_test>
)

add_library(002 src/002.c)
add_executable(002_test test/002_test.c)
target_link_libraries(002_test PRIVATE 002)
target_link_libraries(002_test PRIVATE utils)
add_test(
    NAME 002
    COMMAND $<TARGET_FILE:002_test>
)

add_library(003 src/003.c)
target_link_libraries(003 PUBLIC m)
add_executable(003_test test/003_test.c)
target_link_libraries(003_test PRIVATE 003)
target_link_libraries(003_test PRIVATE utils)
add_test(
    NAME 003
    COMMAND $<TARGET_FILE:003_test>
)

add_library(004 src/004.c)
add_executable(004_test test/004_test.c)
target_link_libraries(004_test PRIVATE 004)
target_link_libraries(004_test PRIVATE utils)
add_test(
    NAME 004
    COMMAND $<TARGET_FILE:004_test>
)

add_library(012 src/012.c)
target_link_libraries(012 PUBLIC m)
add_executable(012_test test/012_test.c)
target_link_libraries(012_test PRIVATE 012)
target_link_libraries(012_test PRIVATE utils)
add_test(
    NAME 012
    COMMAND $<TARGET_FILE:012_test>
)
