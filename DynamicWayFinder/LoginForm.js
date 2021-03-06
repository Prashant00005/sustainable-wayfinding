import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  TextInput,
  TouchableOpacity,
  KeyboardAvoidingView,
  StatusBar
} from 'react-native';

export default class LoginForm extends Component {
  render() {
    return (
      <KeyboardAvoidingView behavior = "padding" style={styles.container}>
      <StatusBar
        barStyle = "light-content"
      />
        <TextInput
          placeholder = "User name or email"
          placeholderTextColor = '#cccccc'
          returnKeyType="next"
          keyboardType = "email-address"
          autoCorrect = {false}
          autoCapitalize = "none"
          onSubmitEditing = {()=> this.passwordInput.focus()}
          style = {styles.input}>
        </TextInput>

        <TextInput
          placeholder ="Password"
          placeholderTextColor ='#cccccc'
          secureTextEntry
          returnKeyType="go"
          ref = {(input)=>this.passwordInput = input}
          style = {styles.input}>
        </TextInput>

        <TouchableOpacity style = {styles.buttonContainer}>
        <Text style ={styles.loginbutton}>LOGIN</Text>
        </TouchableOpacity>
      </KeyboardAvoidingView>
    );
  }
}



const styles = StyleSheet.create({
  container: {
    padding :20
  },
  input:{
    minWidth:300,
    flexWrap:'wrap',
    height : 40,
    backgroundColor: 'rgba(255,255,255,0.2)',
    paddingHorizontal : 10,
    color:'#fff',
    marginBottom : 10,
  },
  buttonContainer:{
    backgroundColor: "#1980b9",
    paddingVertical:10,
    marginTop:15,
    marginBottom:20
  },
  loginbutton:{
    color: '#ffffff',
    textAlign:'center',
    fontWeight:'700'
  }
});