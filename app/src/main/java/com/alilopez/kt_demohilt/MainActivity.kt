package com.alilopez.kt_demohilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alilopez.demo.features.jsonplaceholder.presentation.screens.JsonPlaceHolderScreen
import com.alilopez.kt_demohilt.core.navigation.FeatureNavGraph
import com.alilopez.kt_demohilt.core.navigation.NavigationWrapper
import com.alilopez.kt_demohilt.core.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var navGraphs: Set<@JvmSuppressWildcards FeatureNavGraph>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                //regiber was here
                NavigationWrapper(navGraphs = navGraphs.toList())
            }
        }
    }
}

