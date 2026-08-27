package com.arunk.dashboardlogin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// 1. Model Data Mahasiswa
data class Mahasiswa(
    val nim: String,
    val nama: String,
    val kelas: String
)

// 2. Main Screen Data Mahasiswa
@Composable
fun DataScreen(
    onBack: () -> Unit
) {
    var dataMahasiswa by remember {
        mutableStateOf(
            listOf(
                Mahasiswa("001", "Nafla", "TRM-6A"),
                Mahasiswa("002", "Aulia", "TRM-6A"),
                Mahasiswa("003", "Fahmi", "TRM-6B")
            )
        )
    }

    var nim by remember { mutableStateOf("") }
    var nama by remember { mutableStateOf("") }
    var kelas by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "DATA MAHASISWA",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Form Input Field
        OutlinedTextField(
            value = nim,
            onValueChange = { nim = it },
            label = { Text("NIM") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = kelas,
            onValueChange = { kelas = it },
            label = { Text("Kelas") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Tombol Tambah Data
        Button(
            onClick = {
                if (nim.isNotEmpty() && nama.isNotEmpty() && kelas.isNotEmpty()) {
                    dataMahasiswa = dataMahasiswa + Mahasiswa(
                        nim = nim,
                        nama = nama,
                        kelas = kelas
                    )
                    nim = ""
                    nama = ""
                    kelas = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("TAMBAH DATA")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // List Data Mahasiswa
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(dataMahasiswa) { mahasiswa ->
                MahasiswaItem(
                    mahasiswa = mahasiswa,
                    onDelete = {
                        dataMahasiswa = dataMahasiswa - mahasiswa
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("KEMBALI")
        }
    }
}

// 3. Komponen Card Item Mahasiswa
@Composable
fun MahasiswaItem(
    mahasiswa: Mahasiswa,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = mahasiswa.nama,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(text = "NIM : ${mahasiswa.nim}")
            Text(text = "Kelas : ${mahasiswa.kelas}")

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                OutlinedButton(
                    onClick = onDelete
                ) {
                    Text("Hapus")
                }
            }
        }
    }
}