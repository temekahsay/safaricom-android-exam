package temesgen.girmay.safaricom.feature_auth.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.AddCard
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.ReceiptLong
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Smartphone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Mock Transaction Entity for Section 3
data class Transaction(
    val id: String,
    val name: String,
    val category: String, // "Bank" or "Airtime"
    val amount: String,   // e.g., "+1500.00" or "-200.00"
    val date: String      // e.g., "Today", "Yesterday"
)

// Service item representation for Section 2
data class ServiceItem(
    val name: String,
    val icon: ImageVector
)

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    val transactions = listOf(
        Transaction("1", "Abebe Bikila", "Bank", "+2,500.00 ETB", "Today"),
        Transaction("2", "Safaricom Airtime", "Airtime", "-100.00 ETB", "Today"),
        Transaction("3", "Kebede Chala", "Bank", "-450.00 ETB", "Yesterday"),
        Transaction("4", "Safaricom Data Bundle", "Airtime", "-250.00 ETB", "Yesterday")
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        // PART 1: Top Section with Red Background
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red)
                .padding(20.dp)
        ) {
            // Requirement 1.1: "Main Balance" around top-left corner
            Text(
                text = "Main Balance",
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Requirement 1.2: Balance in 8 stars
            Text(
                text = "********",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Requirement 1.3: Reward Balance and Errif Balance side by side in a row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Reward Balance Column
                Column {
                    Text(
                        text = "Reward Balance",
                        color = Color.White.copy(alpha = 0.8f),
                        fontSize = 13.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "***",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                // Errif Balance Column
                Column {
                    Text(
                        text = "Errif Balance",
                        color = Color.White.copy(alpha = 0.8f),
                        fontSize = 13.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "***",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // PART 2: 6 Grid Quick-Action Buttons (2 Rows x 3 Columns)
        val services = listOf(
            ServiceItem("Merchant Payment", Icons.Default.AddCard),
            ServiceItem("Bill Payment", Icons.Default.ReceiptLong),
            ServiceItem("Credit & Saving", Icons.Default.AccountBalance),
            ServiceItem("Transfer Money", Icons.Default.Send),
            ServiceItem("Airtime/Package", Icons.Default.PhoneAndroid),
            ServiceItem("More Services", Icons.Default.ExpandMore)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // First Row (First 3 items)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    services.take(3).forEach { service ->
                        ServiceButton(service = service, modifier = Modifier.weight(1f))
                    }
                }

                // Second Row (Remaining 3 items)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    services.drop(3).forEach { service ->
                        ServiceButton(service = service, modifier = Modifier.weight(1f))
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // PART 3: Recent Transactions List
        Text(
            text = "Recent Transactions",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(transactions, key = { it.id }) { item ->
                TransactionRow(transaction = item)
            }
        }
    }
}

@Composable
private fun ServiceButton(
    service: ServiceItem,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable { /* Handle action */ }
            .padding(4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(Color.Red.copy(alpha = 0.1f), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = service.icon,
                contentDescription = service.name,
                tint = Color.Red,
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = service.name,
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium,
            color = Color.DarkGray,
            textAlign = TextAlign.Center,
            lineHeight = 14.sp
        )
    }
}

@Composable
private fun TransactionRow(
    transaction: Transaction
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icon representation based on category
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color(0xFFE8F5E9), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = if (transaction.category == "Bank") Icons.Default.AccountBalance else Icons.Default.Smartphone,
                    contentDescription = transaction.category,
                    tint = Color(0xFF2E7D32),
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // User name & category
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = transaction.name,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = transaction.category,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }

            // Amount & Date
            Column(horizontalAlignment = Alignment.End) {
                val isPositive = transaction.amount.startsWith("+")
                Text(
                    text = transaction.amount,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isPositive) Color(0xFF2E7D32) else Color.Black
                )
                Text(
                    text = transaction.date,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
    }
}