// existing
package temesgen.girmay.safaricom.feature_auth.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// existing
@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    onSignInClick: () -> Unit = {}
) {
    // updated
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center // Updated to center UI vertically
    ) {
        // updated
        Button(
            onClick = onSignInClick,
            // Transparent background (no red fill)
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier.fillMaxWidth()
        ) {
            // Updated text color to Red
            Text(
                text = "Sign In",
                color = Color.Red
            )
        }

        // existing
        Spacer(modifier = Modifier.height(16.dp))

        // existing
        Text(
            text = "P-PESA NO.",
            style = MaterialTheme.typography.bodyLarge
        )

        // existing
        Spacer(modifier = Modifier.height(8.dp))

        // existing
        Text(
            text = "SIGNING IN",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}