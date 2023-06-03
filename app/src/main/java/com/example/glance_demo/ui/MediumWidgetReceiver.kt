package com.example.glance_demo.ui

import android.content.Context
import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.action.clickable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.cornerRadius
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.text.Text

class MediumWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = MediumWidget()
}

class MediumWidget : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {

        provideContent {
            Box(
                modifier = GlanceModifier.background(Color.White).padding(10.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalAlignment = Alignment.Top,
                    modifier = GlanceModifier
                        .background(Color.Gray)
                        .cornerRadius(10.dp)
                        .padding(vertical = 5.dp, horizontal = 2.5.dp)
                        .fillMaxSize()
                ) {
                    for (i in 0..2) {
                        Row(
                            modifier = GlanceModifier
                                .fillMaxWidth().padding(vertical = 10.dp)
                        ) {
                            Box(modifier = GlanceModifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .background(Color.White)
                                .clickable {
                                    Log.d("MediumWidget", "click $i")
                                }) {
                                Text("click $i")
                            }
                        }
                    }
                }
            }
        }
    }
}