package com.lingorise.app.data.repository.fakedata

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.lingorise.app.domain.model.UserKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class StoreUserData(private val context: Context) {
    companion object {
        private val Context.dataSore: DataStore<Preferences> by preferencesDataStore("user_type")
        val UserTypeKey = stringPreferencesKey("user_type")
        val DialogStateKey = booleanPreferencesKey("")
    }

    val readUserType: Flow<String?> = context.dataSore.data
        .map { preferences ->
            preferences[UserTypeKey] ?: UserKey().FIRST_TIME
        }

    suspend fun saveUserType(type: String) {
        context.dataSore.edit { preference ->
            preference[UserTypeKey] = type
        }
    }

    val readDialogState: Flow<Boolean> = context.dataSore.data
        .map { pref ->
            pref[DialogStateKey] ?: true
        }
    suspend fun saveDialogState(state: Boolean) {

        context.dataSore.edit { pref ->
            pref[DialogStateKey] = state
        }
    }


}