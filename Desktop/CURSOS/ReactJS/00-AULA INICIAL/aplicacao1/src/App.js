import React, { Component } from 'react'
import logo from './logo.svg'

import Footer from './Footer'
import Home from './Home'
import base from './base'
import {BrowserRouter as Router, Route} from 'react-router-dom'
import NovoAnuncio from './NovoAnuncio'


/*
-cria o ambiante do projeto
npm install -g create-react-app

-cria todos os arquivos do projeto
create-react-app nome_aplicaçao


-iniciar react
yarn start

-instalar controlador de navegação(se necessario)
quando o programa tiver mais de uma pagina necessita de um router
por causa da navegação single page

yarn add react-router-dom


/*Primeiros Exemplos
//Exemplo de elemento puro que não recebe nada(meio inutil)
//cons Elemento = <h1>batata<h1/>


//Exemplo de Componente (funciona parecido com os arquivos de reutilização xml do android) 
//functional statless component : função que não mantem o estado interno
//devido a utilização de uma função mutavel interna(props) que retorna uma estrutura e recebe informação 
const Component1 = (props) => {
  return <h1>{props.name}</h1>
}

//Programa para criar instalador
//_Inno Setup Compiler; http://adf.ly/1bZt7p
//https://www.youtube.com/watch?v=jesZur7Ym6w


//ReactJS é REATIVO (reage amudanças)

const Counter = props =>{
  return <h1>
  Counter:{this.props.counter}
  </h1>
}

*/



class App extends Component {
  
  constructor(props){
    super(props)
    this.state = {
      cadegorias: []
    }

    base.bindToState('categorias',{
      context:this,
      state:'categorias'

    })
  }
  /*constructor(props){
    super(props)

    this.state = {
      counter: 0
    }
    
    setInterval(() => {
      this.setState({counter: this.state.counter+1})
    }, 1000)
    }
*/

  render() {

    return (
      <Router>
        <div className="App">   
          <Route path = '/' exact render={() => <Home categorias={this.state.cadegorias}/>}/>
          <Route path = '/novo-anuncio' exact component = {NovoAnuncio}/>
          <Footer/> 
        </div>
      </Router>
    );
  }
}

export default App;
