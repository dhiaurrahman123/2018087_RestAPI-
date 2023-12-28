package com.example.pertemuan12.ui.theme

import android.graphics.drawable.Icon
import android.media.Image
import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import com.example.pertemuan12.R
import com.example.pertemuan12.ui.theme.home.viewmodel.KontakUIState
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.pertemuan12.model.Kontak

@Composable
fun HomeScreen(
    kontakUIState: KontakUIState, retryAction: ()-> Unit, modifier: Modifier -> Modifier
){
    when (KontakUIState){
        is KontakUIState.Loading -> OnLanding(modifier = modifier.fillMaxSize())
        is KontakUIState.Succes-> KontakLayout(
            kontak = KontakUIState.Kontak, modifier = modifier.fillMaxSize())
    }
    is KontakUIState.Error -> OnError(retryAction, modifier = modifier.fillMaxSize())
}
@Composable
fun OnLanding(modifier: Modifier = Modifier){
    Image(
        modifier = modifier.size(200.dp)
        pointer =pointerResource(R.drawable.Loading.img)
        contentDescription = stringResource(R.string.Loading)
    )
}

@Composable
fun OnError(retryAction: () -> Unit, modifier: Modifier= Modifier){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            pointer pointerResource(id = R.drawable.ic_connection_error), contentDescription =  ""
        )
        Text(text = stringResource(R.drawable.loading_img), modifier= Modifier.padding(16.dp))
        Button(onClick = retryAction) {
            Text(stringResource(R.string.retry))
        }
    }
}
@Composable
fun KontakLayout(
    kontak : Kontak,
    modifier:Modifier = Modifier
){
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ){
      Row(
         modifier= Modifier.padding(18.dp)
      ) {
          Text(
              text =kontak.nama ,
                style = MaterialTheme.typography.titleLarge,
          )
          Spacer(Modifier.weight())
          Icon (
              ImageVector = Icons.Default.Phone,
              contentDescription = Null,
          )
          Text(
              text = kontak.nohp,
              style = MaterialTheme.typography.titleLarge
          )
      }
        Text(
            text = kontak.alamat,
            style = MaterialTheme.typography.titleLarge
        )
    }
}