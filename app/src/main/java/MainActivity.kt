package temesgen.girmay.safaricom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import temesgen.girmay.safaricom.feature_auth.presentation.HomeScreen
import temesgen.girmay.safaricom.feature_auth.presentation.MpesaPinScreen
import temesgen.girmay.safaricom.feature_auth.presentation.SignInScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var currentScreen by remember { mutableStateOf("sign_in") }

                    when (currentScreen) {
                        "sign_in" -> {
                            SignInScreen(
                                onSignInClick = { currentScreen = "mpesa_pin" }
                            )
                        }
                        "mpesa_pin" -> {
                            MpesaPinScreen(
                                onSuccessLogin = {
                                    currentScreen = "home"
                                }
                            )
                        }
                        "home" -> {
                            HomeScreen()
                        }
                    }
                }
            }
        }
    }
}