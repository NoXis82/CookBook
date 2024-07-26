package com.noxis.cookbook

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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noxis.cookbook.ui.theme.CookBookTheme
import com.noxis.database.dao.CookBookDao
import com.noxis.database.entity.NationalFoodsTypeDBO
import com.noxis.nationalfood.domain.model.NationalFoodsType
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CookBookTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val viewModel: TestViewModel = hiltViewModel()
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CookBookTheme {
        Greeting("Android")
    }
}

@HiltViewModel
class TestViewModel @Inject constructor(
    private val cookBookDao: Provider<CookBookDao>
) : ViewModel() {

    init {
        viewModelScope.launch {
            val test1 = NationalFoodsType("Test1").toMap()
            val test2 = NationalFoodsType("Test2").toMap()
            val test3 = NationalFoodsType("Test3").toMap()

            cookBookDao.get().insert(
                test1, test2, test3
            )
        }
    }


}

fun NationalFoodsType.toMap(): NationalFoodsTypeDBO {
    return NationalFoodsTypeDBO(
        0,
        this.name
    )
}
