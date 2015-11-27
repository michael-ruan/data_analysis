# Data Analysis

`Data Analysis` is data analysis programs using `Pig`.

`douban_reader/get_big_man.pig` is get the best people at an particular knowledge in Douban(豆瓣) according to their book lists. The data(book lists) is collected by the python program `crawler`. In my case, I have collect the readers who have alread read books about big data or machine learning, and the result is saved in `reader_list_final`.

`douban_reader/PigUDF` is the pig UDF program to calculate the scores of each readers written with JAVA. The weight of each factor can be set freely.


## Contributor
[Michael Ruan](http://www.linkedin.com/profile/view?id=218589527&trk=nav_responsive_tab_profile_pic) (阮崇鹤)

## Copyright & License

    The MIT License (MIT)

    Copyright (c) 2014 Chonghe Ruan

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in
    all copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
    THE SOFTWARE.