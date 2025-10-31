import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Currículum Vitae',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        textTheme: TextTheme(
          bodyMedium: TextStyle(fontSize: 16, fontFamily: 'Arial'),
        ),
      ),
      home: CurriculumScreen(),
    );
  }
}

class CurriculumScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Currículum Vitae'),
        centerTitle: true,
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: SingleChildScrollView(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              // Sección de Perfil
              Center(
                child: CircleAvatar(
                  radius: 50,
                  backgroundImage: AssetImage('assets/images/profile_picture.jpg'),
                ),
              ),
              SizedBox(height: 16),
              Center(
                child: Text(
                  'Juan Pérez',
                  style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
                ),
              ),
              Center(
                child: Text(
                  'Desarrollador Flutter',
                  style: TextStyle(fontSize: 18, color: Colors.grey[700]),
                ),
              ),
              Divider(thickness: 2),
              
              // Sección de Información de Contacto
              SectionTitle(title: 'Información de Contacto'),
              InfoRow(label: 'Correo:', value: 'juan.perez@email.com'),
              InfoRow(label: 'Teléfono:', value: '+34 600 123 456'),
              InfoRow(label: 'LinkedIn:', value: 'linkedin.com/in/juanperez'),
              InfoRow(label: 'GitHub:', value: 'github.com/juanperez'),
              SizedBox(height: 20),
              
              // Sección de Experiencia Laboral
              SectionTitle(title: 'Experiencia Laboral'),
              ExperienceItem(
                companyName: 'Tech Solutions',
                role: 'Desarrollador Flutter',
                period: '2022 - Actualidad',
                description:
                    'Desarrollo de aplicaciones móviles usando Flutter y Dart, integración de APIs RESTful y gestión de base de datos local.',
              ),
              ExperienceItem(
                companyName: 'App Creators',
                role: 'Desarrollador Backend',
                period: '2020 - 2022',
                description: 'Desarrollo de APIs RESTful y gestión de bases de datos.',
              ),
              SizedBox(height: 20),

              // Sección de Educación
              SectionTitle(title: 'Educación'),
              EducationItem(
                degree: 'Grado en Ingeniería Informática',
                institution: 'Universidad de Madrid',
                period: '2016 - 2020',
              ),
              EducationItem(
                degree: 'Diplomado en Programación de Aplicaciones',
                institution: 'Escuela Técnica de Programación',
                period: '2014 - 2016',
              ),
              SizedBox(height: 20),

              // Sección de Habilidades
              SectionTitle(title: 'Habilidades'),
              SkillItem(skill: 'Flutter/Dart'),
              SkillItem(skill: 'Python'),
              SkillItem(skill: 'JavaScript'),
              SkillItem(skill: 'SQL'),
              SizedBox(height: 20),

              // Resumen Personal
              SectionTitle(title: 'Resumen'),
              Text(
                'Soy un desarrollador de software con más de 3 años de experiencia en el desarrollo de aplicaciones móviles usando Flutter. Me apasiona crear soluciones eficientes y de alta calidad que impacten positivamente en los usuarios.',
                style: TextStyle(fontSize: 16),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

class SectionTitle extends StatelessWidget {
  final String title;
  
  SectionTitle({required this.title});

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 8.0),
      child: Text(
        title,
        style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
      ),
    );
  }
}

class InfoRow extends StatelessWidget {
  final String label;
  final String value;
  
  InfoRow({required this.label, required this.value});

  @override
  Widget build(BuildContext context) {
    return Row(
      children: [
        Text('$label ', style: TextStyle(fontWeight: FontWeight.bold)),
        Expanded(child: Text(value)),
      ],
    );
  }
}

class ExperienceItem extends StatelessWidget {
  final String companyName;
  final String role;
  final String period;
  final String description;

  ExperienceItem({
    required this.companyName,
    required this.role,
    required this.period,
    required this.description,
  });

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 8.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(
            '$companyName - $role',
            style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
          ),
          Text(
            period,
            style: TextStyle(fontSize: 16, color: Colors.grey[600]),
          ),
          SizedBox(height: 4),
          Text(
            description,
            style: TextStyle(fontSize: 16),
          ),
        ],
      ),
    );
  }
}

class EducationItem extends StatelessWidget {
  final String degree;
  final String institution;
  final String period;

  EducationItem({
    required this.degree,
    required this.institution,
    required this.period,
  });

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 8.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(
            '$degree',
            style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
          ),
          Text(
            institution,
            style: TextStyle(fontSize: 16, color: Colors.grey[600]),
          ),
          SizedBox(height: 4),
          Text(
            period,
            style: TextStyle(fontSize: 16),
          ),
        ],
      ),
    );
  }
}

class SkillItem extends StatelessWidget {
  final String skill;

  SkillItem({required this.skill});

  @override
  Widget build(BuildContext context) {
    return Text(
      '• $skill',
      style: TextStyle(fontSize: 16),
    );
  }
}
