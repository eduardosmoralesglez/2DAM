import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

//TODO: Ajustar el encabezado y pie del curriculum, 
//re-ajustar los colores deacuerdo con la plantilla,
//colocar los iconos y marcos de la manera correcta

void main() {
  runApp(const ResumeApp());
}

class ResumeApp extends StatelessWidget {
  const ResumeApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Plantilla CV',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        textTheme: GoogleFonts.quicksandTextTheme(), // estética limpia
        scaffoldBackgroundColor: const Color(0xFFF5F5F5),
      ),
      home: const ResumePage(),
    );
  }
}

class ResumePage extends StatelessWidget {
  const ResumePage({super.key});

  // Colores basados en la plantilla
  static const Color dark = Color(0xFF2B2B2B);
  static const Color darkGray = Color(0xFF4B4B4B);
  static const Color mediumGray = Color(0xFF6D6D6D);
  static const Color accent = Color(0xFFEA5A2A); // naranja acento

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: LayoutBuilder(builder: (context, bc) {
          final width = bc.maxWidth;
          // En pantallas estrechas apilar verticalmente
          final bool isNarrow = width < 800;

          return SingleChildScrollView(
            padding: const EdgeInsets.all(16.0),
            child: Center(
              child: ConstrainedBox(
                constraints: const BoxConstraints(maxWidth: 1100),
                child: isNarrow ? _buildVertical() : _buildHorizontal(),
              ),
            ),
          );
        }),
      ),
    );
  }

  Widget _buildHorizontal() {
    return Container(
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.circular(6),
        boxShadow: const [
          BoxShadow(color: Colors.black12, blurRadius: 12, offset: Offset(0,6))
        ],
      ),
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          // COLUMNA IZQUIERDA (oscura)
          Flexible(
            flex: 4,
            child: Container(
              color: darkGray,
              padding: const EdgeInsets.symmetric(horizontal: 22, vertical: 22),
              child: Stack(
                clipBehavior: Clip.none,
                children: [
                  Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      // Espacio superior para el símbolo naranja
                      Row(
                        children: [
                          // símbolo tipo asterisco naranja
                          Icon(Icons.ac_unit, color: accent, size: 34), // placeholder
                          const SizedBox(width: 12),
                          const SizedBox.shrink(),
                        ],
                      ),
                      const SizedBox(height: 12),
                      // Nombre y profesión
                      Text(
                        'Ricardo\nLópez',
                        style: GoogleFonts.quicksand(
                          fontSize: 36,
                          fontWeight: FontWeight.w700,
                          color: Colors.white,
                          height: 1.0,
                        ),
                      ),
                      const SizedBox(height: 6),
                      Text(
                        'Fotógrafo',
                        style: GoogleFonts.quicksand(
                          fontSize: 18,
                          color: Colors.white70,
                          fontWeight: FontWeight.w500,
                        ),
                      ),
                      const SizedBox(height: 26),
                      // EDUCACIÓN
                      _sectionTitle('EDUCACIÓN'),
                      const SizedBox(height: 12),
                      _educationBlock(
                        title: 'UNIVERSIDAD LA SIERRA',
                        date: 'EGRESADO EN MAYO 2020',
                        subtitle: 'LICENCIATURA EN COMUNICACIÓN Y ARTES VISUALES',
                      ),
                      const SizedBox(height: 12),
                      _educationBlock(
                        title: 'ESCUELA DE FOTOGRAFÍA',
                        date: 'EGRESADO EN DICIEMBRE 2020',
                        subtitle: 'CERTIFICACIÓN EN FOTOGRAFÍA EDITORIAL Y DIRECCIÓN ARTÍSTICA',
                      ),
                      const SizedBox(height: 20),
                      _sectionTitle('HABILIDADES'),
                      const SizedBox(height: 12),
                      _skillRow('IDIOMA 1', 0.9),
                      const SizedBox(height: 8),
                      _skillRow('IDIOMA 2', 0.6),
                      const SizedBox(height: 8),
                      _skillRow('SOFTWARE 1', 0.7),
                      const SizedBox(height: 8),
                      _skillRow('SOFTWARE 2', 0.45),
                      const SizedBox(height: 22),
                      _sectionTitle('LOGROS'),
                      const SizedBox(height: 12),
                      Text(
                        'GANADOR DEL CONCURSO DE ANUAL DE INNOVACIÓN Y EMPRENDIMIENTO EDICIÓN 2022\n\nCERTIFICACIÓN DE MEJORA CONTINUA EN PROCESOS ADMINISTRATIVOS POR EL INSTITUTO FAUGET DE NEGOCIOS.',
                        style: GoogleFonts.quicksand(
                          fontSize: 12,
                          color: Colors.white70,
                          height: 1.3,
                        ),
                      ),
                      const SizedBox(height: 24),
                      // footer con iconos de contacto
                      Divider(color: Colors.white12),
                      const SizedBox(height: 8),
                      Row(
                        children: [
                          const Icon(Icons.phone, color: Colors.white70, size: 18),
                          const SizedBox(width: 8),
                          Text('(55) 1234 5678', style: TextStyle(color: Colors.white70)),
                        ],
                      ),
                      const SizedBox(height: 8),
                      Row(
                        children: [
                          const Icon(Icons.email, color: Colors.white70, size: 18),
                          const SizedBox(width: 8),
                          Text('hola@sitioincreible.com', style: TextStyle(color: Colors.white70)),
                        ],
                      ),
                      const SizedBox(height: 8),
                      Row(
                        children: [
                          const Icon(Icons.public, color: Colors.white70, size: 18),
                          const SizedBox(width: 8),
                          Text('www.sitioincreible.com', style: TextStyle(color: Colors.white70)),
                        ],
                      ),
                    ],
                  ),
                  // Foto circular en la parte superior derecha (solapada)
                  Positioned(
                    top: -36,
                    right: -36,
                    child: Container(
                      width: 140,
                      height: 140,
                      decoration: BoxDecoration(
                        shape: BoxShape.circle,
                        color: Colors.white,
                        boxShadow: const [BoxShadow(blurRadius: 8, color: Colors.black26, offset: Offset(0,4))],
                      ),
                      child: ClipOval(
                        child: Image.asset(
                          'assets/profile.jpg', // reemplaza con tu foto
                          fit: BoxFit.cover,
                          errorBuilder: (c, e, s) => Container(
                            color: Colors.grey[200],
                            child: const Center(child: Icon(Icons.person, size: 56, color: Colors.grey)),
                          ),
                        ),
                      ),
                    ),
                  ),
                ],
              ),
            ),
          ),

          // COLUMNA DERECHA (blanca)
          Flexible(
            flex: 6,
            child: Container(
              padding: const EdgeInsets.symmetric(horizontal: 28, vertical: 26),
              color: Colors.white,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  _rightHeader(),
                  const SizedBox(height: 18),
                  _experienceBlock(
                    company: 'FOTÓGRAFO FREELANCE',
                    role: 'FOTÓGRAFO JUNIOR',
                    period: 'JULIO 2023 - ACTUAL',
                    bullets: [
                      'FOTOGRAFÍA EN EVENTOS SOCIALES, SESIONES EDITORIALES Y DE PRODUCTO.',
                      'LÍDER EN EVENTOS DE ALTO ALCANCE.',
                      'EDICIÓN DE FOTOGRAFÍA.',
                      'COORDINACIÓN CREATIVA DE PROYECTOS.',
                    ],
                  ),
                  const SizedBox(height: 10),
                  const Divider(),
                  const SizedBox(height: 10),
                  _experienceBlock(
                    company: 'AGENCIA VANDIERE',
                    role: 'FOTÓGRAFO SENIOR',
                    period: 'ENERO 2021 - JULIO 2023',
                    bullets: [
                      'FOTOGRAFÍA EN EVENTOS SOCIALES, SESIONES EDITORIALES Y DE PRODUCTO.',
                      'LÍDER EN EVENTOS DE ALTO ALCANCE.',
                      'EDICIÓN DE FOTOGRAFÍA.',
                      'COORDINACIÓN CREATIVA DE PROYECTOS.',
                    ],
                  ),
                  const SizedBox(height: 10),
                  const Divider(),
                  const SizedBox(height: 10),
                  _experienceBlock(
                    company: 'AGENCIA BORCELLE',
                    role: 'FOTÓGRAFO JUNIOR',
                    period: 'JULIO 2019 - ENERO 2021',
                    bullets: [
                      'FOTOGRAFÍA EN EVENTOS SOCIALES, SESIONES EDITORIALES Y DE PRODUCTO.',
                      'AUXILIAR EN EVENTOS DE ALTO ALCANCE.',
                      'EDICIÓN DE FOTOGRAFÍA.',
                    ],
                  ),
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }

  Widget _buildVertical() {
    // Variante para móviles: columna superior (oscura con foto), luego experiencia
    return Column(
      children: [
        Container(
          decoration: BoxDecoration(
            color: darkGray,
            borderRadius: BorderRadius.circular(6),
          ),
          padding: const EdgeInsets.symmetric(horizontal: 18, vertical: 18),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Row(
                children: [
                  Icon(Icons.ac_unit, color: accent, size: 34),
                  const SizedBox(width: 12),
                ],
              ),
              const SizedBox(height: 8),
              Row(
                children: [
                  Expanded(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text('Ricardo\nLópez', style: GoogleFonts.quicksand(fontSize: 30, fontWeight: FontWeight.w700, color: Colors.white)),
                        const SizedBox(height: 6),
                        Text('Fotógrafo', style: GoogleFonts.quicksand(fontSize: 16, color: Colors.white70)),
                      ],
                    ),
                  ),
                  Container(
                    width: 96,
                    height: 96,
                    decoration: BoxDecoration(
                      shape: BoxShape.circle,
                      border: Border.all(color: Colors.white, width: 4),
                    ),
                    child: ClipOval(
                      child: Image.asset('assets/profile.jpg', fit: BoxFit.cover, errorBuilder: (c,e,s)=> Icon(Icons.person, size: 48, color: Colors.white70)),
                    ),
                  ),
                ],
              ),
              const SizedBox(height: 14),
              _sectionTitle('EDUCACIÓN', color: Colors.white),
              const SizedBox(height: 10),
              _educationBlock(
                title: 'UNIVERSIDAD LA SIERRA',
                date: 'EGRESADO EN MAYO 2020',
                subtitle: 'LICENCIATURA EN COMUNICACIÓN Y ARTES VISUALES',
                small: true,
              ),
              const SizedBox(height: 10),
              _educationBlock(
                title: 'ESCUELA DE FOTOGRAFÍA',
                date: 'EGRESADO EN DICIEMBRE 2020',
                subtitle: 'CERTIFICACIÓN EN FOTOGRAFÍA EDITORIAL Y DIRECCIÓN ARTÍSTICA',
                small: true,
              ),
              const SizedBox(height: 12),
              _sectionTitle('HABILIDADES', color: Colors.white),
              const SizedBox(height: 8),
              _skillRow('IDIOMA 1', 0.9),
              const SizedBox(height: 8),
              _skillRow('IDIOMA 2', 0.6),
              const SizedBox(height: 8),
              _skillRow('SOFTWARE 1', 0.7),
              const SizedBox(height: 8),
              _skillRow('SOFTWARE 2', 0.45),
              const SizedBox(height: 12),
              _sectionTitle('LOGROS', color: Colors.white),
              const SizedBox(height: 8),
              Text(
                'GANADOR DEL CONCURSO DE ANUAL DE INNOVACIÓN Y EMPRENDIMIENTO EDICIÓN 2022\n\nCERTIFICACIÓN DE MEJORA CONTINUA EN PROCESOS ADMINISTRATIVOS POR EL INSTITUTO FAUGET DE NEGOCIOS.',
                style: GoogleFonts.quicksand(fontSize: 12, color: Colors.white70),
              ),
            ],
          ),
        ),
        const SizedBox(height: 12),
        // Experiencia en un contenedor blanco separado
        Container(
          decoration: BoxDecoration(color: Colors.white, borderRadius: BorderRadius.circular(6)),
          padding: const EdgeInsets.all(14),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              _rightHeader(),
              const SizedBox(height: 10),
              _experienceBlock(
                company: 'FOTÓGRAFO FREELANCE',
                role: 'FOTÓGRAFO JUNIOR',
                period: 'JULIO 2023 - ACTUAL',
                bullets: [
                  'FOTOGRAFÍA EN EVENTOS SOCIALES, SESIONES EDITORIALES Y DE PRODUCTO.',
                  'LÍDER EN EVENTOS DE ALTO ALCANCE.',
                  'EDICIÓN DE FOTOGRAFÍA.',
                  'COORDINACIÓN CREATIVA DE PROYECTOS.',
                ],
              ),
              const SizedBox(height: 8),
              const Divider(),
              const SizedBox(height: 8),
              _experienceBlock(
                company: 'AGENCIA VANDIERE',
                role: 'FOTÓGRAFO SENIOR',
                period: 'ENERO 2021 - JULIO 2023',
                bullets: [
                  'FOTOGRAFÍA EN EVENTOS SOCIALES, SESIONES EDITORIALES Y DE PRODUCTO.',
                  'LÍDER EN EVENTOS DE ALTO ALCANCE.',
                  'EDICIÓN DE FOTOGRAFÍA.',
                  'COORDINACIÓN CREATIVA DE PROYECTOS.',
                ],
              ),
              const SizedBox(height: 8),
              const Divider(),
              const SizedBox(height: 8),
              _experienceBlock(
                company: 'AGENCIA BORCELLE',
                role: 'FOTÓGRAFO JUNIOR',
                period: 'JULIO 2019 - ENERO 2021',
                bullets: [
                  'FOTOGRAFÍA EN EVENTOS SOCIALES, SESIONES EDITORIALES Y DE PRODUCTO.',
                  'AUXILIAR EN EVENTOS DE ALTO ALCANCE.',
                  'EDICIÓN DE FOTOGRAFÍA.',
                ],
              ),
            ],
          ),
        ),
      ],
    );
  }

  Widget _sectionTitle(String text, {Color? color}) {
    return Container(
      padding: const EdgeInsets.symmetric(horizontal: 10, vertical: 8),
      decoration: BoxDecoration(
        color: color ?? Colors.white,
        borderRadius: BorderRadius.circular(24),
      ),
      child: Text(
        text,
        style: GoogleFonts.quicksand(
          fontSize: 14,
          fontWeight: FontWeight.w700,
          color: color == null ? darkGray : dark,
        ),
      ),
    );
  }

  Widget _educationBlock({required String title, required String date, required String subtitle, bool small = false}) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(title, style: GoogleFonts.quicksand(fontSize: small ? 14 : 16, fontWeight: FontWeight.w700, color: Colors.white)),
        const SizedBox(height: 6),
        Text(date, style: GoogleFonts.quicksand(fontSize: 12, fontWeight: FontWeight.w700, color: Colors.white70)),
        const SizedBox(height: 6),
        Text(subtitle, style: GoogleFonts.quicksand(fontSize: 12, color: Colors.white70)),
      ],
    );
  }

  Widget _skillRow(String label, double value) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(label, style: GoogleFonts.quicksand(fontSize: 12, color: Colors.white70)),
        const SizedBox(height: 6),
        Container(
          height: 14,
          decoration: BoxDecoration(
            color: Colors.white12,
            borderRadius: BorderRadius.circular(8),
          ),
          child: FractionallySizedBox(
            alignment: Alignment.centerLeft,
            widthFactor: value,
            child: Container(
              decoration: BoxDecoration(
                color: accent,
                borderRadius: BorderRadius.circular(8),
              ),
            ),
          ),
        ),
      ],
    );
  }

  Widget _rightHeader() {
    return Row(
      crossAxisAlignment: CrossAxisAlignment.end,
      children: [
        Expanded(
          child: Text(
            'EXPERIENCIA LABORAL',
            style: GoogleFonts.quicksand(fontSize: 18, fontWeight: FontWeight.w800, color: darkGray),
          ),
        ),
        // decorativo (círculo o icono) placeholder
        Container(
          width: 36,
          height: 36,
          decoration: BoxDecoration(
            color: accent,
            borderRadius: BorderRadius.circular(18),
          ),
          child: const Center(child: Icon(Icons.work, color: Colors.white, size: 18)),
        ),
      ],
    );
  }

  Widget _experienceBlock({
    required String company,
    required String role,
    required String period,
    required List<String> bullets,
  }) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 6),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(company, style: GoogleFonts.quicksand(fontSize: 16, fontWeight: FontWeight.w800, color: dark)),
          const SizedBox(height: 6),
          Row(
            children: [
              Text(role, style: GoogleFonts.quicksand(fontSize: 14, fontWeight: FontWeight.w700, color: darkGray)),
              const SizedBox(width: 12),
              Text(period, style: GoogleFonts.quicksand(fontSize: 12, color: mediumGray)),
            ],
          ),
          const SizedBox(height: 8),
          ...bullets.map((b) => Padding(
                padding: const EdgeInsets.symmetric(vertical: 4),
                child: Text('• $b', style: GoogleFonts.quicksand(fontSize: 12, color: darkGray, height: 1.3)),
              )),
        ],
      ),
    );
  }
}
