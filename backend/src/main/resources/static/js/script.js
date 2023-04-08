var app = new Vue({
    el: '#app',
    data: {
        rows: [],
        editForm:{
            id:"",
            name:"",
            year:"",
            rank:""
        }

    },
    methods: {
        async function() {
            // await for the promise to yield a result
            let response = await fetch('http://localhost:8080/api/movies');   // blocking
            let json = await response.json();
            this.rows = json;
            // console.log(json);
        },

        editMovie(row){

            this.editForm['id'] = row.id;
            console.log(this.editForm['id']);
            console.log(row.id);
          
        },
        async saveMovie () {
            let id = this.editForm['id'];
            let name = this.editForm['name'];
            let year = this.editForm['year'];
            let rank = this.editForm['rank'];
            let bodyJson = {
                "id": id,
                "name": name,
                "year": year,
                "rank": rank
                       
            }
            
             const settings = {
                method: 'PUT',
                headers: {
                    Accept: 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(bodyJson)
            };
            let response = await fetch(`http://localhost:8080/api/movies/${id}`,  settings );
            let json = await response.json();
            this.rows = json;
            location.reload();
        },
       async deleteMovie(row){
           console.log(row.id);
           let id = row.id;
            let response = await fetch(`http://localhost:8080/api/movies/${id}`, { method: 'DELETE' });
            let json = await response.json();
            this.rows = json;
           }
        // sortList(sortBy) {
        //     if (this.sorted) {
        //       this.rows.sort((x, y) => (x[sortBy] > y[sortBy] ? -1 : 1));
        //       this.sorted = false;
        //       switch (sortBy) {
        //         case 'id':
        //           this.dir['id'] = 'down';
        //           this.dir['name'] = '';
        //           this.dir['phone'] = '';
        //           break;
        //         case 'name':
        //           this.dir['id'] = '';
        //           this.dir['name'] = 'down';
        //           this.dir['phone'] = '';
        //           break;
        //         case 'phone':
        //           this.dir['id'] = '';
        //           this.dir['name'] = '';
        //           this.dir['phone'] = 'down';
        //           break;
        //       };
        //     } else {
        //       this.rows.sort((x, y) => (x[sortBy] < y[sortBy] ? -1 : 1));
        //       this.sorted = true;
        //       switch (sortBy) {
        //         case 'id':
        //           this.dir['id'] = 'up';
        //           this.dir['name'] = '';
        //           this.dir['phone'] = '';
        //           break;
        //         case 'name':
        //           this.dir['id'] = '';
        //           this.dir['name'] = 'up';
        //           this.dir['phone'] = '';
        //           break;
        //         case 'phone':
        //           this.dir['id'] = '';
        //           this.dir['name'] = '';
        //           this.dir['phone'] = 'up';
        //           break;
        //       };
        //     }
        // }
    },
    mounted() {
      this.function()
    }
});

