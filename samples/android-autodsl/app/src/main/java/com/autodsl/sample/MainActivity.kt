/*
 * Copyright 2018 Juan Ignacio Saravia
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.autodsl.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView.setOnClickListener {
            sequence {
                // up right
                +together {
                    +TranslateX(0f, 150f)
                    +TranslateY(0f, -150f)
                }
                // left
                +TranslateX(150f, -150f)
                // down right
                +together {
                    +translateX {
                        from = -150f
                        to = 150f
                    }
                    +TranslateY(-150f, 150f)
                }
                // left
                +TranslateX(150f, -150f)
                // center
                +together {
                    +TranslateX(-150f, 0f)
                    +TranslateY(150f, 0f)
                }
            }.runOn(it)
        }
    }
}