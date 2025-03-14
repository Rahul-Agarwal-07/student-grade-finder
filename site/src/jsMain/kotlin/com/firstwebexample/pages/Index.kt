package com.firstwebexample.pages

import androidx.compose.runtime.*
import com.firstwebexample.components.calculate
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.maxWidth
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import org.jetbrains.compose.web.dom.*
import com.varabyte.kobweb.silk.components.forms.*
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.theme.colors.ColorPalette
import com.varabyte.kobweb.silk.theme.colors.ColorPalettes
import kotlinx.browser.document
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.AlignSelf
import org.jetbrains.compose.web.css.alignSelf
import org.jetbrains.compose.web.css.fontSize

@Page
@Composable
fun index() {

    var output by remember {
        mutableStateOf("")
    }

    var maths by remember { mutableStateOf(0) }
    var chem by remember { mutableStateOf(0) }
    var phy by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {


            H1(
                attrs = {
                    style {
                        color(Colors.Red)
                    }
                }
            )
            {
                Text("Student Grade Calculator")
            }


                Div(
                    attrs = {
                    }
                )
                {
                    Input(
                        type = InputType.Number,
                        attrs = {
                            placeholder("Maths")
                            classes("input1")

                            style {
                                margin(20.px)
                                padding(20.px)
                            }

                            id("maths_marks")
                            onChange { maths = it.value!!.toInt() }
                        }
                    )
                }

                Div()
                {
                    Input(
                        type = InputType.Number,
                        attrs = {
                            placeholder("Chemistry")
                            classes("input2")
                            style {
                                margin(20.px)
                                padding(20.px)
                            }
                            id("chem_marks")
                            onChange { chem = it.value!!.toInt() }
                        },
                    )
                }

                Div()
                {
                    Input(
                        type = InputType.Number,
                        attrs = {
                            placeholder("Physics")
                            classes("input3")
                            style {
                                margin(20.px)
                                padding(20.px)
                            }
                            id("phy_marks")
                            onChange { phy = it.value!!.toInt() }
                        }
                    )
                }

                Div(
                    attrs = {
                        style {
                            alignSelf(AlignSelf.Center)
                        }
                    }
                )
                {
                    Button(
                        modifier = Modifier
                            .width(150.px)
                            .height(50.px)
                            .padding(10.px)
                            .margin(20.px)
                            .backgroundColor(Colors.White)
                            .border(2.px, LineStyle.Solid,Colors.Red)
                            .color(Colors.Red),

                        type = ButtonType.Submit,
                        onClick = { output = calculate(maths,phy,chem) },

                        )
                    {
                        Text("Show Grade")
                    }


                    Button(
                        modifier = Modifier
                            .width(150.px)
                            .height(50.px)
                            .padding(10.px)
                            .margin(10.px)
                            .backgroundColor(Colors.Red)
                            .color(Colors.White),

                        type = ButtonType.Reset,
                        onClick = { output = "" },
                        )
                    {
                        Text("Reset")
                    }

                }


        H2(
            attrs = {
                style {
                    color(Colors.Red)
                }
            }
        )
        {
            Text(output)
        }
    }
}

