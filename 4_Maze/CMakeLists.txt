cmake_minimum_required(VERSION 3.15)
project(4_Maze)

set(CMAKE_CXX_STANDARD 14)

include_directories(headers)

add_executable(4_Maze
        headers/cell.h
        headers/constants.h
        headers/direction.h
        headers/dsu.h
        headers/maze.h
        sources/cell.cpp
        sources/dsu.cpp
        sources/maze.cpp
        CMakeLists.txt
        main.cpp)
