//
// Created by dunidin on 15.03.2020.
//

#ifndef INC_4_MAZE_DIRECTION_H
#define INC_4_MAZE_DIRECTION_H

enum direction {
    up = 0,
    right = 1,
    down = 2,
    left = 3
};

static direction dirs[4] = {up, right, down, left};
static direction opposite[4] = {down, left, up, right};
static int8_t dx[4] = {-1, 0, 1, 0};
static int8_t dy[4] = {0, 1, 0, -1};

#endif //INC_4_MAZE_DIRECTION_H
